package org.apache.commons.lang3.concurrent;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* loaded from: classes4.dex */
public class EventCountCircuitBreaker extends AbstractCircuitBreaker<Integer> {
    private static final Map<AbstractCircuitBreaker.State, StateStrategy> STRATEGY_MAP = createStrategyMap();
    private final AtomicReference<CheckIntervalData> checkIntervalData;
    private final long closingInterval;
    private final int closingThreshold;
    private final long openingInterval;
    private final int openingThreshold;

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit, int i2, long j2, TimeUnit timeUnit2) {
        this.checkIntervalData = new AtomicReference<>(new CheckIntervalData(0, 0L));
        this.openingThreshold = i;
        this.openingInterval = timeUnit.toNanos(j);
        this.closingThreshold = i2;
        this.closingInterval = timeUnit2.toNanos(j2);
    }

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit, int i2) {
        this(i, j, timeUnit, i2, j, timeUnit);
    }

    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit) {
        this(i, j, timeUnit, i);
    }

    public int getOpeningThreshold() {
        return this.openingThreshold;
    }

    public long getOpeningInterval() {
        return this.openingInterval;
    }

    public int getClosingThreshold() {
        return this.closingThreshold;
    }

    public long getClosingInterval() {
        return this.closingInterval;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean checkState() {
        return performStateCheck(0);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean incrementAndCheckState(Integer num) {
        return performStateCheck(num.intValue());
    }

    public boolean incrementAndCheckState() {
        return incrementAndCheckState((Integer) 1);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void open() {
        super.open();
        this.checkIntervalData.set(new CheckIntervalData(0, nanoTime()));
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        super.close();
        this.checkIntervalData.set(new CheckIntervalData(0, nanoTime()));
    }

    private boolean performStateCheck(int i) {
        AbstractCircuitBreaker.State state;
        CheckIntervalData checkIntervalData;
        CheckIntervalData nextCheckIntervalData;
        do {
            long nanoTime = nanoTime();
            state = this.state.get();
            checkIntervalData = this.checkIntervalData.get();
            nextCheckIntervalData = nextCheckIntervalData(i, checkIntervalData, state, nanoTime);
        } while (!updateCheckIntervalData(checkIntervalData, nextCheckIntervalData));
        if (stateStrategy(state).isStateTransition(this, checkIntervalData, nextCheckIntervalData)) {
            state = state.oppositeState();
            changeStateAndStartNewCheckInterval(state);
        }
        return !isOpen(state);
    }

    private boolean updateCheckIntervalData(CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
        return checkIntervalData == checkIntervalData2 || this.checkIntervalData.compareAndSet(checkIntervalData, checkIntervalData2);
    }

    private void changeStateAndStartNewCheckInterval(AbstractCircuitBreaker.State state) {
        changeState(state);
        this.checkIntervalData.set(new CheckIntervalData(0, nanoTime()));
    }

    private CheckIntervalData nextCheckIntervalData(int i, CheckIntervalData checkIntervalData, AbstractCircuitBreaker.State state, long j) {
        if (stateStrategy(state).isCheckIntervalFinished(this, checkIntervalData, j)) {
            return new CheckIntervalData(i, j);
        }
        return checkIntervalData.increment(i);
    }

    long nanoTime() {
        return System.nanoTime();
    }

    private static StateStrategy stateStrategy(AbstractCircuitBreaker.State state) {
        return STRATEGY_MAP.get(state);
    }

    private static Map<AbstractCircuitBreaker.State, StateStrategy> createStrategyMap() {
        EnumMap enumMap = new EnumMap(AbstractCircuitBreaker.State.class);
        enumMap.put((EnumMap) AbstractCircuitBreaker.State.CLOSED, (AbstractCircuitBreaker.State) new StateStrategyClosed());
        enumMap.put((EnumMap) AbstractCircuitBreaker.State.OPEN, (AbstractCircuitBreaker.State) new StateStrategyOpen());
        return enumMap;
    }

    private static class CheckIntervalData {
        private final long checkIntervalStart;
        private final int eventCount;

        CheckIntervalData(int i, long j) {
            this.eventCount = i;
            this.checkIntervalStart = j;
        }

        public int getEventCount() {
            return this.eventCount;
        }

        public long getCheckIntervalStart() {
            return this.checkIntervalStart;
        }

        public CheckIntervalData increment(int i) {
            return i == 0 ? this : new CheckIntervalData(getEventCount() + i, getCheckIntervalStart());
        }
    }

    private static abstract class StateStrategy {
        protected abstract long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker);

        public abstract boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2);

        private StateStrategy() {
        }

        public boolean isCheckIntervalFinished(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, long j) {
            return j - checkIntervalData.getCheckIntervalStart() > fetchCheckInterval(eventCountCircuitBreaker);
        }
    }

    private static class StateStrategyClosed extends StateStrategy {
        private StateStrategyClosed() {
            super();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getEventCount() > eventCountCircuitBreaker.getOpeningThreshold();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        protected long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getOpeningInterval();
        }
    }

    private static class StateStrategyOpen extends StateStrategy {
        private StateStrategyOpen() {
            super();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getCheckIntervalStart() != checkIntervalData.getCheckIntervalStart() && checkIntervalData.getEventCount() < eventCountCircuitBreaker.getClosingThreshold();
        }

        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        protected long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getClosingInterval();
        }
    }
}

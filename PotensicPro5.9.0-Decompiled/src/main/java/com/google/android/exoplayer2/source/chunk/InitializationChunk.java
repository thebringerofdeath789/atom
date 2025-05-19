package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
public final class InitializationChunk extends Chunk {
    private final ChunkExtractor chunkExtractor;
    private volatile boolean loadCanceled;
    private long nextLoadPosition;
    private ChunkExtractor.TrackOutputProvider trackOutputProvider;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, i, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.chunkExtractor = chunkExtractor;
    }

    public void init(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.trackOutputProvider = trackOutputProvider;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException {
        if (this.nextLoadPosition == 0) {
            this.chunkExtractor.init(this.trackOutputProvider, C.TIME_UNSET, C.TIME_UNSET);
        }
        try {
            DataSpec subrange = this.dataSpec.subrange(this.nextLoadPosition);
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, subrange.position, this.dataSource.open(subrange));
            while (!this.loadCanceled && this.chunkExtractor.read(defaultExtractorInput)) {
                try {
                } finally {
                    this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.position;
                }
            }
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}

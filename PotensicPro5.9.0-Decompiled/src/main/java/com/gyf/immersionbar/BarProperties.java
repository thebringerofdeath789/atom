package com.gyf.immersionbar;

/* loaded from: classes2.dex */
public class BarProperties {
    private boolean hasNavigationBar;
    private boolean landscapeLeft;
    private boolean landscapeRight;
    private int navigationBarHeight;
    private int navigationBarWidth;
    private int notchHeight;
    private boolean notchScreen;
    private boolean portrait;
    private int statusBarHeight;

    public boolean isPortrait() {
        return this.portrait;
    }

    void setPortrait(boolean z) {
        this.portrait = z;
    }

    public boolean isLandscapeLeft() {
        return this.landscapeLeft;
    }

    void setLandscapeLeft(boolean z) {
        this.landscapeLeft = z;
    }

    public boolean isLandscapeRight() {
        return this.landscapeRight;
    }

    void setLandscapeRight(boolean z) {
        this.landscapeRight = z;
    }

    public boolean isNotchScreen() {
        return this.notchScreen;
    }

    void setNotchScreen(boolean z) {
        this.notchScreen = z;
    }

    public boolean hasNavigationBar() {
        return this.hasNavigationBar;
    }

    void setNavigationBar(boolean z) {
        this.hasNavigationBar = z;
    }

    public int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    void setStatusBarHeight(int i) {
        this.statusBarHeight = i;
    }

    public int getNavigationBarHeight() {
        return this.navigationBarHeight;
    }

    void setNavigationBarHeight(int i) {
        this.navigationBarHeight = i;
    }

    public int getNavigationBarWidth() {
        return this.navigationBarWidth;
    }

    void setNavigationBarWidth(int i) {
        this.navigationBarWidth = i;
    }

    public int getNotchHeight() {
        return this.notchHeight;
    }

    void setNotchHeight(int i) {
        this.notchHeight = i;
    }
}

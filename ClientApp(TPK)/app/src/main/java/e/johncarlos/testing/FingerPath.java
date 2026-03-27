package e.johncarlos.testing;

import android.graphics.Path;

public class FingerPath {
    public int color1;
    public boolean emboss;
    public boolean blur;
    public int strokeWidth;
    public Path path;

    public FingerPath(int color1, boolean emboss, boolean blur, int strokeWidth, Path path) {
        this.color1 = color1;
        this.emboss = emboss;
        this.blur = blur;
        this.strokeWidth = strokeWidth;
        this.path = path;
    }
}

package Data;

import Models.Colors.ColorData;
import Models.Colors.ColorList;

import java.util.ArrayList;
import java.util.List;

public class Colors {
    private static final ColorList COLOR_LIST;

    static {
        List<ColorData> colors = new ArrayList<>();
        colors.add(
                new ColorData(
                        1,
                        "cerulean",
                        2000,
                        "#98B2D1",
                        "15-4020"
                )
        );
        colors.add(
                new ColorData(
                        2,
                        "fuchsia rose",
                        2001,
                        "#C74375",
                        "17-2031"
                )
        );
        colors.add(
                new ColorData(
                        3,
                        "true red",
                        2002,
                        "#BF1932",
                        "19-1664"
                )
        );
        colors.add(
                new ColorData(
                        4,
                        "aqua sky",
                        2003,
                        "#7BC4C4",
                        "14-4811"
                )
        );
        colors.add(
                new ColorData(
                        5,
                        "tigerlily",
                        2004,
                        "#E2583E",
                        "17-1456"
                )
        );
        colors.add(
                new ColorData(
                        6,
                        "blue turquoise",
                        2005,
                        "#53B0AE",
                        "15-5217"
                )
        );

        COLOR_LIST = new ColorList(1, 6, 12, 2, colors);
    }

    public static ColorList getColorList() {
        return COLOR_LIST;
    }
}

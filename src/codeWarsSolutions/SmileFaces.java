package codeWarsSolutions;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmileFaces {
    public static int countSmileys(List<String> arr) {
        List<String> eyes = Arrays.asList(":", ";");
        List<String> noses = Arrays.asList("~", "-");
        List<String> mouths = Arrays.asList(")", "D");

        return (int) arr.stream().filter(
                s -> {
                    String[] split = s.split("");

                    if (s.length() <= 1) return false;
                    else {
                        boolean hasEyes = eyes.contains(split[0]);
                        boolean hasMouth = mouths.contains(split[1]);

                        if (s.length() == 2) return hasEyes && hasMouth;
                        else if (s.length() == 3) {
                            boolean hasNose = noses.contains(split[1]);
                            hasMouth = mouths.contains(split[2]);

                            return hasEyes && hasNose && hasMouth;
                        }
                        return false;
                    }
                }
        ).count();
    }
}




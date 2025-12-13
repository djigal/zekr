public class TestAlafasyUrl {
    public static void main(String[] args) {
        // Test du formatage de l'URL
        String onlineUrl = "https://everyayah.com/data/Alafasy_128kbps/%1$03d%2$03d.mp3";

        // Test pour sourate 1, aya 1
        String result1 = String.format(onlineUrl, 1, 1);
        System.out.println("Sourate 1, Aya 1: " + result1);

        // Test pour sourate 2, aya 255 (Ayat al-Kursi)
        String result2 = String.format(onlineUrl, 2, 255);
        System.out.println("Sourate 2, Aya 255: " + result2);

        // Test pour sourate 114, aya 6
        String result3 = String.format(onlineUrl, 114, 6);
        System.out.println("Sourate 114, Aya 6: " + result3);

        // Vérifier si les URLs sont correctes
        System.out.println("\nURLs attendues:");
        System.out.println("https://everyayah.com/data/Alafasy_128kbps/001001.mp3");
        System.out.println("https://everyayah.com/data/Alafasy_128kbps/002255.mp3");
        System.out.println("https://everyayah.com/data/Alafasy_128kbps/114006.mp3");
    }
}


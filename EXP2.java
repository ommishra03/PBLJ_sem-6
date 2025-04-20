import java.util.*;

class Video {
    private String title;
    private boolean checkedOut;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public String getStatus() {
        return checkedOut ? "Checked Out" : "Available";
    }
}

class Inventory {
    private List<Video> videos = new ArrayList<>();

    public void addVideo(String title) {
        videos.add(new Video(title));
    }

    public void checkOutVideo(String title) {
        for (Video v : videos) {
            if (v.getTitle().equalsIgnoreCase(title) && !v.isCheckedOut()) {
                v.checkOut();
                return;
            }
        }
    }

    public void returnVideo(String title) {
        for (Video v : videos) {
            if (v.getTitle().equalsIgnoreCase(title) && v.isCheckedOut()) {
                v.returnVideo();
                return;
            }
        }
    }

    public void listInventory() {
        for (Video v : videos) {
            System.out.println(v.getTitle() + " - " + v.getStatus());
        }
    }
}

public class VideoRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Video\n2. Check Out Video\n3. Return Video\n4. Show Inventory\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter video title: ");
                    String title = scanner.nextLine();
                    inventory.addVideo(title);
                    break;
                case 2:
                    System.out.print("Enter video title to check out: ");
                    title = scanner.nextLine();
                    inventory.checkOutVideo(title);
                    break;
                case 3:
                    System.out.print("Enter video title to return: ");
                    title = scanner.nextLine();
                    inventory.returnVideo(title);
                    break;
                case 4:
                    inventory.listInventory();
                    break;
                case 5:
                    running = false;
                    break;
            }
        }

        scanner.close();
    }
}

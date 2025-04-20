
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class two {

    static class Video {
        String title;
        boolean isCheckedOut;
        double averageRating;
        int ratingCount;

        public Video(String title) {
            this.title = title;
            this.isCheckedOut = false;
            this.averageRating = 0.0;
            this.ratingCount = 0;
        }

        public String checkOut() {
            if (!isCheckedOut) {
                isCheckedOut = true;
                return "Video checked out.";
            } else {
                return "Video is already checked out.";
            }
        }

        public String returnVideo() {
            if (isCheckedOut) {
                isCheckedOut = false;
                return "Video returned.";
            } else {
                return "Video was not checked out.";
            }
        }

        public String receiveRating(int rating) {
            if (rating >= 1 && rating <= 5) {
                averageRating = (averageRating * ratingCount + rating) / (ratingCount + 1);
                ratingCount++;
                return "Rating received.";
            } else {
                return "Invalid rating. Please provide a rating between 1 and 5.";
            }
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Checked Out: " + isCheckedOut + ", Average Rating: " + averageRating;
        }
    }

    static class VideoStore {
        Video[] videos;
        int videoCount;

        public VideoStore() {
            videos = new Video[10];
            videoCount = 0;
        }

        public String addVideo(String title) {
            if (videoCount < 10) {
                Video newVideo = new Video(title);
                videos[videoCount] = newVideo;
                videoCount++;
                return "Video added.";
            } else {
                return "Inventory full. Cannot add more videos.";
            }
        }

        public String checkOut(String title) {
            for (int i = 0; i < videoCount; i++) {
                if (videos[i].title.equals(title)) {
                    return videos[i].checkOut();
                }
            }
            return "Video not found.";
        }

        public String returnVideo(String title) {
            for (int i = 0; i < videoCount; i++) {
                if (videos[i].title.equals(title)) {
                    return videos[i].returnVideo();
                }
            }
            return "Video not found.";
        }

        public String receiveRating(String title, int rating) {
            for (int i = 0; i < videoCount; i++) {
                if (videos[i].title.equals(title)) {
                    return videos[i].receiveRating(rating);
                }
            }
            return "Video not found.";
        }

        public List<String> listInventory() {
            List<String> inventoryList = new ArrayList<>();
            for (int i = 0; i < videoCount; i++) {
                inventoryList.add(videos[i].toString());
            }
            return inventoryList;
        }
    }

    public static void main(String[] args) {
    //     VideoStore store = new VideoStore();

    //     store.addVideo("The Matrix");
    //     store.addVideo("Godfather II");
    //     store.addVideo("Star Wars Episode IV: A New Hope");

    //     store.receiveRating("The Matrix", 5);
    //     store.receiveRating("The Matrix", 4);
    //     store.receiveRating("Godfather II", 5);
    //     store.receiveRating("Godfather II", 5);
    //     store.receiveRating("Star Wars Episode IV: A New Hope", 4);
    //     store.receiveRating("Star Wars Episode IV: A New Hope", 3);

    //     store.checkOut("The Matrix");
    //     store.checkOut("Godfather II");
    //     store.checkOut("Star Wars Episode IV: A New Hope");

    //     store.returnVideo("The Matrix");
    //     store.returnVideo("Godfather II");
    //     store.returnVideo("Star Wars Episode IV: A New Hope");

    //     store.checkOut("Godfather II"); 
        Scanner sc = new Scanner(System.in);
        VideoStore store = new VideoStore();

        while (true) {
            System.out.println("\nWelcome to Video Store");
            System.out.println("Choose an option below:");
            System.out.println("1. Add new Video");
            System.out.println("2. Receive Rating");
            System.out.println("3. Check out a Video");
            System.out.println("4. Return Video");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");

            System.out.print("Enter your option: ");

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter video title to add: ");
                    String titleToAdd = sc.nextLine();
                    System.out.println(store.addVideo(titleToAdd));
                    break;

                case 2:
                    System.out.print("Enter video title to check out: ");
                    String titleToCheckOut = sc.nextLine();
                    System.out.println(store.checkOut(titleToCheckOut));
                    break;

                case 3:
                    System.out.print("Enter video title to rate: ");
                    String titleToRate = sc.nextLine();
                    System.out.print("Enter rating (1 to 5): ");
                    int rating = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println(store.receiveRating(titleToRate, rating));
                    break;

                case 4:
                    System.out.print("Enter video title to return: ");
                    String titleToReturn = sc.nextLine();
                    System.out.println(store.returnVideo(titleToReturn));
                    break;

                case 5:
                    System.out.println("Inventory:");
                    List<String> inventory = store.listInventory();
                    if (inventory.isEmpty()) {
                        System.out.println("No videos in inventory.");
                    } else {
                        for (String videoDetails : inventory) {
                            System.out.println(videoDetails);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
     
     
     
     
    

}
}
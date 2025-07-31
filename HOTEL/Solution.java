import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel[] hotels = new Hotel[4];

        for (int i = 0; i < hotels.length; i++) {
            int hotelId = sc.nextInt(); sc.nextLine();
            String hotelName = sc.nextLine();
            String dateOfBooking = sc.nextLine();
            int noOfRoomsBooked = sc.nextInt(); sc.nextLine();
            String wifiFacility = sc.nextLine();
            double totalBill = sc.nextDouble(); sc.nextLine();

            hotels[i] = new Hotel(hotelId, hotelName, dateOfBooking, noOfRoomsBooked, wifiFacility, totalBill);
        }

        String monthParam = sc.nextLine();
        String wifiParam = sc.nextLine();

        int totalRooms = noOfRoomsBookedInGivenMonth(hotels, monthParam);
        if (totalRooms > 0) {
            System.out.println(totalRooms);
        } else {
            System.out.println("No rooms booked in the given month");
        }

        Hotel result = searchHotelByWifiOption(hotels, wifiParam);
        if (result != null) {
            System.out.println(result.getHotelId());
        } else {
            System.out.println("No such option available");
        }
    }

    public static int noOfRoomsBookedInGivenMonth(Hotel[] hotels, String month) {
        int total = 0;
        for (Hotel h : hotels) {
            String[] parts = h.getDateOfBooking().split("-");
            if (parts.length >= 2 && parts[1].equalsIgnoreCase(month)) {
                total += h.getNoOfRoomsBooked();
            }
        }
        return total;
    }

    public static Hotel searchHotelByWifiOption(Hotel[] hotels, String wifiOption) {
        List<Hotel> matching = new ArrayList<>();
        for (Hotel h : hotels) {
            if (h.getWifiFacility().equalsIgnoreCase(wifiOption)) {
                matching.add(h);
            }
        }
        if (matching.size() < 2) return null;

        // Sort descending by totalBill
        matching.sort((a, b) -> Double.compare(b.getTotalBill(), a.getTotalBill()));
        return matching.get(1); // second highest
    }
}
class Hotel {
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public int getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }

    public String getWifiFacility() {
        return wifiFacility;
    }

    public double getTotalBill() {
        return totalBill;
    }
}
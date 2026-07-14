import java.util.List;


public interface Searchable {
    void search(String query);
    List<Flight> searchFlights(String criteria);
    List<Flight> filterResults(List<Flight> flights, String filter);
    List<Flight> sortResults(List<Flight> flights, String sortBy);
    List<Flight> getSearchResults();
    void displayResults(List<Flight> flights);
    void clearSearchResults();
    boolean hasSearchResults();
    void setSearchCriteria(String criteria);
    String getSearchCriteria();
    void setSearchResults(List<Flight> results);
    List<Flight> getSearchResultsList();
    void displaySearchCriteria();
    void displaySearchResults(Flight flight);
    void displaySearchResults(List<Flight> flights);
    void displaySearchResults(String criteria);
    void displaySearchResults(String criteria, List<Flight> flights);
    void displaySearchResults(String criteria, List<Flight> flights, String sortBy);
    void displaySearchResults(String criteria, List<Flight> flights, String sortBy, String filter);
    void displaySearchResults(String criteria, List<Flight> flights, String sortBy, String
    filter, boolean showDetails);
}


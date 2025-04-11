package edu.cmu.Library;

public class LibraryAccount {
    private LibraryService libraryService;
 
    /**
     * Retrieves an array of checked out books associated with the specified user ID. If the user
     * has no books checked out, the returned list will be empty. Since multiple households may
     * share a single account, the user ID is of the form "libraryID:userName".
     * e.g., "12345:John Doe"
     *
     * @param userId the ID of the user whose books are to be retrieved
     * @return an array of Book objects the user has checked out
     * @throws IllegalArgumentException if the userId is null, empty, or does not follow the required format
     */
    public Book[] getBooks(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        int colonIndex = userId.indexOf(':');
        if (colonIndex <= 0 || colonIndex == userId.length() - 1) {
            throw new IllegalArgumentException("User ID must be in the format 'libraryID:userName'");
        }
        String libraryId = userId.substring(0, colonIndex);
        String userName = userId.substring(colonIndex + 1);

        return libraryService.getBooks(userName, libraryId);        
    }
}

// U1. Don't make users do anything library could do for them
// U2. Be consistent
// Q4. Prevent failure, or fail quickly, predictably, and informatively ("fail fast")
// Q5. Handle boundary conditions (edge cases, corner cases) gracefully
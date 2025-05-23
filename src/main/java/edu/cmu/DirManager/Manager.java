package edu.cmu.DirManager;

public class Manager {
    private DirOps dirOps;
    
    /**
     * Creates a new directory at the specified path.
     *
     * @param path the path where the new directory should be created
     * @throws DirectoryExistsException if the directory already exists
     * @throws InvalidPathException if the path is invalid
     */
    public void newDirectory(String path) throws DirectoryExistsException, InvalidPathException {
        if (dirOps.checkDirectoryExists(path)) {
            throw new DirectoryExistsException("Directory already exists: " + path);
        } else if (!dirOps.checkPathValid(path)) {
            throw new InvalidPathException("Invalid path: " + path);
        } else {
            dirOps.createDirectory(path);
        }
    }
}

// Q3. Make it easy for user to do what's preferable
// Q4. Prevent failure, or fail quickly, predictably, and informatively ("fail fast")
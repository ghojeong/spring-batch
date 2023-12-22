package batch.domain.version.entity;

public enum VersionTarget {
    INIT_DATA,
    PROFILE_TAG,
    DISCOVER,
    QUOTE,
    IOS,
    ANDROID;

    public static VersionTarget from(String versionTarget) {
        return VersionTarget.valueOf(versionTarget.toUpperCase());
    }
}

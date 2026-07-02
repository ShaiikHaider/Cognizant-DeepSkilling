package com.example;

/**
 * Represents a third-party / external API that MyService depends on.
 * In the Mockito exercises this is the interface we mock, since we
 * don't want our tests to make real network calls.
 */
public interface ExternalApi {

    String getData();
}

package com.qalbconnect.qalbconnect.service.adapter;

import java.util.List;
import java.util.Optional;

import com.qalbconnect.qalbconnect.model.ProphetStory;

/**
 * Adapter Pattern: Target Interface
 * Defines the common interface that the client (ProphetStoryFetcher in this case) expects.
 * This abstracts away the specifics of different data storage mechanisms.
 */
public interface ProphetStorySource {
    Optional<ProphetStory> getStoryByName(String name);
    List<String> getAllProphetNames();
}
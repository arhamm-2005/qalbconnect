package com.qalbconnect.qalbconnect.versebymood.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;
import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;

@Component // Spring will manage this bean
public class VerseDataLoader {

    private final Map<Mood, List<MoodVerse>> moodVersesData;

    public VerseDataLoader() {
        this.moodVersesData = new EnumMap<>(Mood.class);
        loadVerses(); // Load data when the component is created
    }

    private void loadVerses() {
        // Happiness
        moodVersesData.computeIfAbsent(Mood.HAPPINESS, k -> new ArrayList<>()).add(new MoodVerse(
            "Indeed, those who believe and do righteous deeds - the Most Merciful will extend to them [His] affection.",
            "Surah Maryam (19:96)"
        ));
        moodVersesData.get(Mood.HAPPINESS).add(new MoodVerse(
            "And We will surely reward those who were patient with the best reward for what they used to do.",
            "Surah Az-Zumar (39:10)"
        ));

        // Sadness
        moodVersesData.computeIfAbsent(Mood.SADNESS, k -> new ArrayList<>()).add(new MoodVerse(
            "Do not lose hope in the mercy of Allah. Indeed, Allah forgives all sins.",
            "Surah Az-Zumar (39:53)"
        ));
        moodVersesData.get(Mood.SADNESS).add(new MoodVerse(
            "And rely upon Allah; and sufficient is Allah as Disposer of affairs.",
            "Surah Al-Ahzab (33:3)"
        ));

        // Anger
        moodVersesData.computeIfAbsent(Mood.ANGER, k -> new ArrayList<>()).add(new MoodVerse(
            "And those who suppress anger and pardon people - indeed, Allah loves the doers of good.",
            "Surah Aal-E-Imran (3:134)"
        ));
        moodVersesData.get(Mood.ANGER).add(new MoodVerse(
            "Repel [evil] by that [deed] which is better; and thereupon the one whom between you and him is enmity [will become] as though he was a devoted friend.",
            "Surah Fussilat (41:34)"
        ));

        // Fear
        moodVersesData.computeIfAbsent(Mood.FEAR, k -> new ArrayList<>()).add(new MoodVerse(
            "Indeed, Allah is with those who fear Him and those who are doers of good.",
            "Surah An-Nahl (16:128)"
        ));
        moodVersesData.get(Mood.FEAR).add(new MoodVerse(
            "And whoever fears Allah - He will make for him a way out and provide for him from where he does not expect.",
            "Surah At-Talaq (65:2-3)"
        ));

        // Excitement
        moodVersesData.computeIfAbsent(Mood.EXCITEMENT, k -> new ArrayList<>()).add(new MoodVerse(
            "So remember Me; I will remember you.",
            "Surah Al-Baqarah (2:152)"
        ));
        moodVersesData.get(Mood.EXCITEMENT).add(new MoodVerse(
            "And when your Lord proclaimed: 'If you are grateful, I will surely increase you [in favor].'",
            "Surah Ibrahim (14:7)"
        ));

        // Stress
        moodVersesData.computeIfAbsent(Mood.STRESS, k -> new ArrayList<>()).add(new MoodVerse(
            "Allah does not burden a soul beyond that it can bear.",
            "Surah Al-Baqarah (2:286)"
        ));
        moodVersesData.get(Mood.STRESS).add(new MoodVerse(
            "And whoever puts their trust in Allah - then He is sufficient for him.",
            "Surah At-Talaq (65:3)"
        ));

        // Love
        moodVersesData.computeIfAbsent(Mood.LOVE, k -> new ArrayList<>()).add(new MoodVerse(
            "Indeed, those who have believed and done righteous deeds - the Most Merciful will appoint for them affection.",
            "Surah Maryam (19:96)"
        ));
        moodVersesData.get(Mood.LOVE).add(new MoodVerse(
            "And He placed between you affection and mercy. Indeed in that are signs for a people who give thought.",
            "Surah Ar-Rum (30:21)"
        ));

        // Hope
        moodVersesData.computeIfAbsent(Mood.HOPE, k -> new ArrayList<>()).add(new MoodVerse(
            "Indeed, with hardship [will be] ease.",
            "Surah Ash-Sharh (94:6)"
        ));
        moodVersesData.get(Mood.HOPE).add(new MoodVerse(
            "And whoever fears Allah - He will make for him a way out.",
            "Surah At-Talaq (65:2)"
        ));

        // Anxiety
        moodVersesData.computeIfAbsent(Mood.ANXIETY, k -> new ArrayList<>()).add(new MoodVerse(
            "Unquestionably, by the remembrance of Allah hearts are assured.",
            "Surah Ar-Ra’d (13:28)"
        ));
        moodVersesData.get(Mood.ANXIETY).add(new MoodVerse(
            "And be patient, for indeed, Allah does not allow the reward of those who do good to be lost.",
            "Surah Hud (11:115)"
        ));

        // Curiosity
        moodVersesData.computeIfAbsent(Mood.CURIOUSITY, k -> new ArrayList<>()).add(new MoodVerse(
            "And He taught Adam the names - all of them.",
            "Surah Al-Baqarah (2:31)"
        ));
        moodVersesData.get(Mood.CURIOUSITY).add(new MoodVerse(
            "And He has taught man that which he knew not.",
            "Surah Al-Alaq (96:5)"
        ));

        // Jealousy
        moodVersesData.computeIfAbsent(Mood.JEALOUSY, k -> new ArrayList<>()).add(new MoodVerse(
            "And do not wish for that by which Allah has made some of you exceed others.",
            "Surah An-Nisa (4:32)"
        ));
        moodVersesData.get(Mood.JEALOUSY).add(new MoodVerse(
            "It is We who have apportioned among them their livelihood in the life of this world.",
            "Surah Az-Zukhruf (43:32)"
        ));

        // Pride
        moodVersesData.computeIfAbsent(Mood.PRIDE, k -> new ArrayList<>()).add(new MoodVerse(
            "Indeed, Allah does not like the arrogant.",
            "Surah An-Nahl (16:23)"
        ));
        moodVersesData.get(Mood.PRIDE).add(new MoodVerse(
            "And do not walk upon the earth exultantly. Indeed, you will never tear the earth [apart], and you will never reach the mountains in height.",
            "Surah Al-Isra (17:37)"
        ));
    }

    public Map<Mood, List<MoodVerse>> getMoodVersesData() {
        return Collections.unmodifiableMap(moodVersesData); // Return an unmodifiable map
    }
}
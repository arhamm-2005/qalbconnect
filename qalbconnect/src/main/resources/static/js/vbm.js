document.addEventListener('DOMContentLoaded', () => {
    // Select all mood buttons
    const moodButtons = document.querySelectorAll('.mood-btn');
    // Get the form element
    const moodForm = document.getElementById('moodForm');
    // Get the hidden input field where the selected mood will be stored
    const hiddenMoodInput = document.getElementById('selectedMoodInput');

    // Check if all necessary elements are present
    if (moodButtons && moodForm && hiddenMoodInput) {
        // Add a click event listener to each mood button
        moodButtons.forEach(button => {
            button.addEventListener('click', () => {
                // Get the mood value from the 'data-mood' attribute of the clicked button
                const mood = button.getAttribute('data-mood');
                // Set the value of the hidden input field to the selected mood
                hiddenMoodInput.value = mood;
                // Submit the form. This will trigger a full page reload and the Spring Controller will process the request.
                moodForm.submit();
            });
        });
    }
});
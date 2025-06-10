document.addEventListener('DOMContentLoaded', () => {
    // Select all action buttons for the Tasbeeh Counter
    const incrementBtn = document.getElementById('increment-btn');
    const resetBtn = document.getElementById('reset-btn');
    const undoBtn = document.getElementById('undo-btn');

    // Get the form element that will submit the action
    const actionForm = document.getElementById('actionForm');
    // Get the hidden input field where the action (increment, reset, undo) will be stored
    const hiddenActionInput = document.getElementById('hiddenAction');

    // Check if all necessary elements are present to prevent errors
    if (incrementBtn && resetBtn && undoBtn && actionForm && hiddenActionInput) {
        // Add a click event listener to the Increment button
        incrementBtn.addEventListener('click', () => {
            hiddenActionInput.value = 'increment'; // Set the hidden input's value to 'increment'
            actionForm.submit(); // Submit the form to the backend
        });

        // Add a click event listener to the Reset button
        resetBtn.addEventListener('click', () => {
            hiddenActionInput.value = 'reset'; // Set the hidden input's value to 'reset'
            actionForm.submit(); // Submit the form to the backend
        });

        // Add a click event listener to the Undo button
        undoBtn.addEventListener('click', () => {
            hiddenActionInput.value = 'undo'; // Set the hidden input's value to 'undo'
            actionForm.submit(); // Submit the form to the backend
        });
    }
});
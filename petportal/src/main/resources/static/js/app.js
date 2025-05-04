// Sign-up and Login functionality (simplified, would need backend integration)
document.getElementById("signup-form")?.addEventListener("submit", function (event) {
    event.preventDefault();
    alert("User signed up successfully!");
});

document.getElementById("login-form")?.addEventListener("submit", function (event) {
    event.preventDefault();
    alert("Login successful!");
});

// Fetch available pets (This will later be replaced with real data from the backend)
document.addEventListener('DOMContentLoaded', () => {
    const pets = [
        { id: 1, name: 'Buddy', type: 'Dog', age: '2 years', description: 'A friendly dog looking for a home.' },
        { id: 2, name: 'Mittens', type: 'Cat', age: '1 year', description: 'A playful cat who loves cuddles.' },
    ];

    const petList = document.getElementById('pet-list');
    pets.forEach(pet => {
        const petCard = document.createElement('div');
        petCard.classList.add('pet-card');
        petCard.innerHTML = `
            <h3>${pet.name}</h3>
            <p>Type: ${pet.type}</p>
            <p>Age: ${pet.age}</p>
            <p>${pet.description}</p>
            <button onclick="adoptPet(${pet.id})">Adopt</button>
        `;
        petList.appendChild(petCard);
    });
});

// Adoption process (simplified)
function adoptPet(petId) {
    alert(`You have adopted pet with ID: ${petId}`);
}

// Admin functionality for adding and removing pets (simplified, would need backend)
document.getElementById("add-pet-form")?.addEventListener("submit", function (event) {
    event.preventDefault();
    alert("New pet added!");
});

document.getElementById("remove-pet-form")?.addEventListener("submit", function (event) {
    event.preventDefault();
    alert("Pet removed!");
});

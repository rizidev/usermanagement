// const signupForm = document.getElementById('signup-form');
// const loginForm = document.getElementById('login-form');
// const userOperations = document.getElementById('user-operations');
// const userDetailsDiv = document.getElementById('user-details');
// const updateButton = document.getElementById('update-button');
// const deleteButton = document.getElementById('delete-button');

// signupForm.addEventListener('submit', async (e) => {
//     e.preventDefault();
//     const name = document.getElementById('signup-name').value;
//     const email = document.getElementById('signup-email').value;

//     const response = await fetch('/api/users', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({ name, email }),
//     });
//     const data = await response.json();
//     alert(`User created with ID: ${data.id}`);
//     signupForm.reset();
// });

// loginForm.addEventListener('submit', async (e) => {
//     e.preventDefault();
//     const id = document.getElementById('login-id').value;

//     const response = await fetch(`/api/users/${id}`);
//     if (response.ok) {
//         const user = await response.json();
//         userDetailsDiv.innerHTML = `ID: ${user.id} <br>Name: ${user.name} <br>`;
//         userOperations.style.display = 'block';
//     } else {
//         alert('User not found');
//     }
// });

// // Add event listeners for update and delete buttons as needed
// updateButton.addEventListener('click', async () => {
//     // Logic to update user details
//     const id = document.getElementById('login-id').value;
//     const name = prompt("Enter new name:");
//     const email = prompt("Enter new email:");

//     const response = await fetch(`/api/users/${id}`, {
//         method: 'PUT',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({ name, email }),
//     });
    
//     if (response.ok) {
//         alert("User updated successfully!");
//         loginForm.dispatchEvent(new Event('submit')); // Refresh user details
//     } else {
//         alert("Error updating user.");
//     }
// });

// deleteButton.addEventListener('click', async () => {
//     const id = document.getElementById('login-id').value;

//     const response = await fetch(`/api/users/${id}`, {
//         method: 'DELETE',
//     });

//     if (response.ok) {
//         alert("User deleted successfully!");
//         userOperations.style.display = 'none'; // Hide operations
//         loginForm.reset();
//     } else {
//         alert("Error deleting user.");
//     }
// });
const signupForm = document.getElementById('signup-form'); 
const loginForm = document.getElementById('login-form');
const userOperations = document.getElementById('user-operations');
const userDetailsDiv = document.getElementById('user-details');
const updateButton = document.getElementById('update-button');
const deleteButton = document.getElementById('delete-button');
const showUserListButton = document.getElementById('show-user-list-button');
const userListDiv = document.getElementById('user-list');
const userListContentDiv = document.getElementById('user-list-content');

// Sign Up Event Listener
signupForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = document.getElementById('signup-name').value;
    const email = document.getElementById('signup-email').value;

    const response = await fetch('/api/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, email }),
    });
    const data = await response.json();
    alert(`User created with ID: ${data.id}`);
    signupForm.reset();
});

// Login Event Listener
loginForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('login-id').value;

    const response = await fetch(`/api/users/${id}`);
    if (response.ok) {
        const user = await response.json();
        userDetailsDiv.innerHTML = `ID: ${user.id} <br>Name: ${user.name} `;
        userOperations.style.display = 'block';
    } else {
        alert('User not found');
    }
});
showUserListButton.addEventListener('click', async () => {
    // Toggle visibility of user list
    if (userListDiv.style.display === 'none' || userListDiv.style.display === '') {
        userListDiv.style.display = 'block'; // Show the user list section
        await fetchUserList(); // Fetch the user list
    } else {
        userListDiv.style.display = 'none'; // Hide the user list section
    }
});
// Show User List Button Event Listener
// showUserListButton.addEventListener('click', async () => {
//     userListDiv.style.display = 'block'; // Show the user list section
//     await fetchUserList(); // Fetch the user list
// });

// Fetch User List Function
async function fetchUserList() {
    const response = await fetch('/api/users');
    if (response.ok) {
        const users = await response.json();
        userListContentDiv.innerHTML = ''; // Clear previous content

        users.forEach(user => {
            const userDiv = document.createElement('div');
            userDiv.innerHTML = `
                ID: ${user.id}, Name: ${user.name}
            `;
            userListContentDiv.appendChild(userDiv);
        });
    } else {
        alert('Error fetching user list.');
    }
}
// // Add event listeners for update and delete buttons as needed
updateButton.addEventListener('click', async () => {
    // Logic to update user details
    const id = document.getElementById('login-id').value;
    const name = prompt("Enter new name:");
    const email = prompt("Enter new email:");

    const response = await fetch(`/api/users/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, email }),
    });
    
    if (response.ok) {
        alert("User updated successfully!");
        loginForm.dispatchEvent(new Event('submit')); // Refresh user details
    } else {
        alert("Error updating user.");
    }
});

deleteButton.addEventListener('click', async () => {
    const id = document.getElementById('login-id').value;

    const response = await fetch(`/api/users/${id}`, {
        method: 'DELETE',
    });

    if (response.ok) {
        alert("User deleted successfully!");
        userOperations.style.display = 'none'; // Hide operations
        loginForm.reset();
    } else {
        alert("Error deleting user.");
    }
});
// Fetch User List Function
async function fetchUserList() {
    const response = await fetch('/api/users');
    if (response.ok) {
        const users = await response.json();
        userListContentDiv.innerHTML = ''; // Clear previous content

        users.forEach(user => {
            const userDiv = document.createElement('div');
            userDiv.innerHTML = `
                ID: ${user.id}, Name: ${user.name}
    
            `;
            userListContentDiv.appendChild(userDiv);
        });
    } else {
        alert('Error fetching user list.');
    }
}

// Function to like a 

// Other event listeners and functions (Update, Delete, etc.)

// Call fetchUserList when the page loads if necessary

// Hash password using SHA-256
async function hashPassword(password) {
    const encoder = new TextEncoder();
    const data = encoder.encode(password);
    const hashBuffer = await crypto.subtle.digest("SHA-256", data);
    return Array.from(new Uint8Array(hashBuffer))
        .map(byte => byte.toString(16).padStart(2, "0"))
        .join("");
}

// Open & Close Modals
function openLogin() { document.getElementById("loginModal").style.display = "flex"; }
function closeLogin() { document.getElementById("loginModal").style.display = "none"; }
function openRegister() { document.getElementById("registerModal").style.display = "flex"; }
function closeRegister() { document.getElementById("registerModal").style.display = "none"; }

// Check login status on page load
document.addEventListener("DOMContentLoaded", function () {
    checkUserStatus();

    // Handle user registration
    document.getElementById("registerForm").addEventListener("submit", async function (event) {
        event.preventDefault();

        const username = document.getElementById("regUsername").value.trim();
        const email = document.getElementById("regEmail").value.trim();
        const firstName = document.getElementById("regFirstName").value.trim();
        const lastName = document.getElementById("regLastName").value.trim();
        const password = document.getElementById("regPassword").value.trim();

        if (!username || !email || !firstName || !lastName || !password) {
            alert("All fields are required!");
            return;
        }

        const hashedPassword = await hashPassword(password);

        const user = {
            username: username,
            password: hashedPassword,
            email: email,
            firstName: firstName,
            lastName: lastName
        };

        try {
            const response = await fetch("http://localhost:8080/users", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(user)
            });

            if (response.status === 200) {
                alert("Registration successful!");
                closeRegister();
            } else {
                alert("Registration failed. Please try again.");
            }
        } catch (error) {
            console.error("Error:", error);
            alert("An error occurred. Please try again.");
        }
    });

    // Handle user login
    document.getElementById("loginForm").addEventListener("submit", async function (event) {
        event.preventDefault();

        const username = document.getElementById("username").value.trim();
        const password = document.getElementById("password").value.trim();

        if (!username || !password) {
            alert("Please enter both username and password.");
            return;
        }

        const hashedPassword = await hashPassword(password);

        try {
            // Fetch user details from backend
            const response = await fetch(`http://localhost:8080/users/${username}`, {
                method: "GET",
                headers: { "Content-Type": "application/json" }
            });

            if (response.status === 200) {
                const user = await response.json();
                
                if (user.password === hashedPassword) {
                    alert("Login successful!");
                    localStorage.setItem("user", username);
                    closeLogin();
                    checkUserStatus();
                } else {
                    alert("Incorrect password.");
                }
            } else {
                alert("User not found.");
            }
        } catch (error) {
            console.error("Error:", error);
            alert("An error occurred. Please try again.");
        }
    });
});

// Check if the user is logged in
function checkUserStatus() {
    const user = localStorage.getItem("user");
    const loginBtn = document.querySelector("li button[onclick='openLogin()']");
    const registerBtn = document.querySelector("li button[onclick='openRegister()']");

    if (user) {
        if (loginBtn) {
            loginBtn.innerText = "Sign Out";
            loginBtn.setAttribute("onclick", "logout()");
        }
        if (registerBtn) registerBtn.style.display = "none"; // Hide Register button
    }
}

// Logout function
function logout() {
    localStorage.removeItem("user");
    location.reload();
}
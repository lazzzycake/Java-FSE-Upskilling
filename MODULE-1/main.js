// 1. JS Setup
console.log("Welcome to the Community Portal");
window.onload = () => alert("Page loaded successfully!");

// 2. Event Details
const eventName = "Art Exhibition";
const eventDate = "2025-06-15";
let availableSeats = 20;
console.log(`${eventName} on ${eventDate}. Seats available: ${availableSeats}`);

// 3. Show valid events
const events = [
  { name: "Music Fest", date: "2025-07-20", seats: 10 },
  { name: "Old Meetup", date: "2023-05-10", seats: 0 }
];

events.forEach(event => {
  if (new Date(event.date) > new Date() && event.seats > 0) {
    console.log(`Available: ${event.name}`);
  }
});

// 4. Functions
function registerUser(eventName) {
  const event = events.find(e => e.name === eventName);
  try {
    if (event && event.seats > 0) {
      event.seats--;
      console.log("Registered successfully!");
    } else {
      throw new Error("No seats available");
    }
  } catch (err) {
    console.error(err.message);
  }
}

// 5. Object and Prototype
function Event(name, seats) {
  this.name = name;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

// 6. Array Map & Filter
const musicEvents = events.filter(e => e.name.includes("Music"));
const formatted = events.map(e => `${e.name} - ${e.date}`);

// 7. DOM Manipulation
function handleSubmit(event) {
  event.preventDefault();
  document.getElementById("confirmationMsg").textContent = "Thank you for registering!";
}

// 8. Event Handling
function handleEventChange() {
  const type = document.getElementById("eventType").value;
  console.log("Selected Event Type:", type);
}

// 9. Async/Await
async function fetchEvents() {
  try {
    const res = await fetch("https://mockapi.io/events");
    const data = await res.json();
    console.log(data);
  } catch (err) {
    console.error("Fetch failed", err);
  }
}

// 10. Modern JS
const clone = [...events];
const [{ name: firstEvent }] = events;

// 11. Form Validation
function validatePhone() {
  const phone = document.getElementById("phone").value;
  if (!/^[0-9]{10}$/.test(phone)) {
    alert("Invalid phone number");
  }
}

function countChars(event) {
  console.log("Character count:", event.target.value.length);
}

// 12. AJAX Simulation
function postData() {
  fetch("https://mockapi.io/register", {
    method: "POST",
    body: JSON.stringify({ user: "John" }),
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(data => alert("Success!"))
    .catch(err => alert("Failed"));
}

// 13. Debugging Logs
console.log("Form loaded");
document.getElementById("registrationForm").addEventListener("submit", e => {
  console.log("Form submitted");
});

// 14. Video Handling
function showVideoReady() {
  document.getElementById("videoMsg").textContent = "Video ready to play!";
}

// Preferences and Geolocation
function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();
}

function findLocation() {
  navigator.geolocation.getCurrentPosition(
    position => {
      document.getElementById("locationDisplay").textContent =
        `Latitude: ${position.coords.latitude}, Longitude: ${position.coords.longitude}`;
    },
    error => {
      document.getElementById("locationDisplay").textContent = `Error: ${error.message}`;
    },
    { enableHighAccuracy: true, timeout: 10000 }
  );
}

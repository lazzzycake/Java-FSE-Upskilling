// 1. JS Setup
console.log("Welcome to the Community Portal");
window.onload = () => alert("Page loaded successfully!");

// 2. Event Details
const eventName = "Art Exhibition";
const eventDate = "2025-06-15";
let availableSeats = 20;
console.log(`${eventName} on ${eventDate}. Seats available: ${availableSeats}`);

// 3. Conditions & Loops
const events = [
  { name: "Music Fest", date: "2025-07-20", seats: 10 },
  { name: "Old Meetup", date: "2023-05-10", seats: 0 }
];

events.forEach(event => {
  if (new Date(event.date) > new Date() && event.seats > 0) {
    console.log(`Available: ${event.name}`);
  }
});

// 4. Functions & Closures
function addEvent(event) {
  events.push(event);
}

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

function createCategoryCounter() {
  let count = 0;
  return function () {
    count++;
    return count;
  };
}

// 5. Object Prototypes
function Event(name, seats) {
  this.name = name;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

// 6. Array Methods
const musicEvents = events.filter(e => e.name.includes("Music"));
const displayCards = events.map(e => `${e.name} - ${e.date}`);

// 7. DOM Manipulation
const output = document.getElementById("confirmationMsg");

function handleSubmit(event) {
  event.preventDefault();
  output.textContent = "Thank you for registering!";
}

// 8. Event Handling
function handleEventChange() {
  const eventType = document.getElementById("eventType").value;
  console.log("Selected:", eventType);
}

// 9. Async/Await
async function fetchEvents() {
  document.body.classList.add("loading");
  try {
    const res = await fetch("https://mockapi.io/events");
    const data = await res.json();
    console.log(data);
  } catch (err) {
    console.error("Fetch error", err);
  } finally {
    document.body.classList.remove("loading");
  }
}

// 10. Modern JS
const clone = [...events];
const [{ name: firstEvent }] = events;

// 11. Form Handling
function validatePhone() {
  const phone = document.getElementById("phone").value;
  if (!/^\d{10}$/.test(phone)) {
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
  })
    .then(res => res.json())
    .then(data => alert("Success!"))
    .catch(err => alert("Failed"));
}

// 13. Debugging
console.log("Form loaded");
document.getElementById("registrationForm").addEventListener("submit", e => {
  console.log("Form submitted");
});

// 14. jQuery (if used)
// $('#registerBtn').click(() => alert("Registered"));
// $('.eventCard').fadeIn();

function showVideoReady() {
  document.getElementById("videoMsg").textContent = "Video ready to play!";
}

// 8. Preferences
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

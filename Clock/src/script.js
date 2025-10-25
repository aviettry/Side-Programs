let debugMode = false;
let debugDate = null;
let clockInterval;
let starsCreated = false;

function updateClock() {
    let now;

    if (debugMode) {
        // In debug mode, advance time by 1 hour from the last debug time
        debugDate.setHours(debugDate.getHours() + 1);
        now = new Date(debugDate);
    } else {
        // Regular mode: use real time
        now = new Date();
    }

    let hours = now.getHours();
    const minutes = now.getMinutes().toString().padStart(2, '0');
    const ampm = hours >= 12 ? '下午' : '上午';

    // Convert to 12-hour format
    const displayHours = hours % 12;
    const formattedHours = (displayHours ? displayHours : 12).toString();

    const timeString = ampm + ' ' + formattedHours + ':' + minutes;
    document.getElementById('clock').textContent = timeString;

    // Format and display date in 'M - DD - YYYY' format
    const month = now.getMonth() + 1; // getMonth() is zero-based
    const day = now.getDate().toString().padStart(2, '0');
    const year = now.getFullYear();
    const dateString = `${month} - ${day} - ${year}`;
    document.getElementById('date').textContent = dateString;

    // Display day of week in Chinese
    const chineseDays = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    const dayOfWeek = now.getDay(); // 0 = Sunday, 1 = Monday, etc.
    document.getElementById('day').textContent = chineseDays[dayOfWeek];

    // Update background and celestial objects based on time of day
    updateBackground(hours, minutes);
}

function createStars() {
    if (starsCreated) return;

    const background = document.getElementById('background');
    const numStars = 100;

    for (let i = 0; i < numStars; i++) {
        const star = document.createElement('div');
        star.classList.add('star');

        // Random position
        star.style.left = `${Math.random() * 100}%`;
        star.style.top = `${Math.random() * 70}%`; // Keep stars in upper 70% of sky

        // Some stars are brighter
        if (Math.random() > 0.7) {
            star.classList.add('bright');
        }

        background.appendChild(star);
    }

    starsCreated = true;
}

function updateBackground(hours, minutes) {
    // Convert time to decimal for smooth transitions (0-24 scale)
    const timeDecimal = hours + (minutes / 60);

    // Create stars if they don't exist yet
    createStars();

    // Define colors for different times of day
    const colors = {
        dawn: { r: 135, g: 81, b: 138 },      // 5-7: Purple dawn
        morning: { r: 102, g: 178, b: 255 },   // 7-10: Light blue morning
        midday: { r: 64, g: 156, b: 255 },     // 10-14: Blue midday
        afternoon: { r: 244, g: 170, b: 66 },  // 14-17: Orange afternoon
        sunset: { r: 211, g: 85, b: 97 },      // 17-19: Red sunset
        evening: { r: 46, g: 49, b: 107 },     // 19-22: Dark blue evening
        night: { r: 26, g: 26, b: 53 }         // 22-5: Dark night
    };

    let color1, color2, ratio;

    // Determine which two colors to blend based on time
    if (timeDecimal >= 5 && timeDecimal < 7) {
        // Dawn: 5-7
        color1 = colors.night;
        color2 = colors.dawn;
        ratio = (timeDecimal - 5) / 2;
    } else if (timeDecimal >= 7 && timeDecimal < 10) {
        // Morning: 7-10
        color1 = colors.dawn;
        color2 = colors.morning;
        ratio = (timeDecimal - 7) / 3;
    } else if (timeDecimal >= 10 && timeDecimal < 14) {
        // Midday: 10-14
        color1 = colors.morning;
        color2 = colors.midday;
        ratio = (timeDecimal - 10) / 4;
    } else if (timeDecimal >= 14 && timeDecimal < 17) {
        // Afternoon: 14-17
        color1 = colors.midday;
        color2 = colors.afternoon;
        ratio = (timeDecimal - 14) / 3;
    } else if (timeDecimal >= 17 && timeDecimal < 19) {
        // Sunset: 17-19
        color1 = colors.afternoon;
        color2 = colors.sunset;
        ratio = (timeDecimal - 17) / 2;
    } else if (timeDecimal >= 19 && timeDecimal < 22) {
        // Evening: 19-22
        color1 = colors.sunset;
        color2 = colors.evening;
        ratio = (timeDecimal - 19) / 3;
    } else {
        // Night: 22-5
        if (timeDecimal >= 22) {
            color1 = colors.evening;
            color2 = colors.night;
            ratio = (timeDecimal - 22) / 7; // 22-24 is part of the transition
        } else {
            color1 = colors.evening;
            color2 = colors.night;
            ratio = (timeDecimal + 2) / 7; // 0-5 is the rest of the transition
        }
    }

    // Interpolate between the two colors
    const r = Math.floor(color1.r + ratio * (color2.r - color1.r));
    const g = Math.floor(color1.g + ratio * (color2.g - color1.g));
    const b = Math.floor(color1.b + ratio * (color2.b - color1.b));

    // Apply the color to the background
    document.getElementById('background').style.backgroundColor = `rgb(${r}, ${g}, ${b})`;

    // Update sun and moon positions based on time
    updateCelestialBodies(timeDecimal);
}

function updateCelestialBodies(timeDecimal) {
    const sun = document.getElementById('sun');
    const moon = document.getElementById('moon');
    const stars = document.querySelectorAll('.star');

    // Calculate sun position - visible from 5 to 19 (5am to 7pm)
    if (timeDecimal >= 5 && timeDecimal <= 19) {
        // Calculate sun's progress through the sky (0 to 1)
        const sunProgress = (timeDecimal - 5) / 14;

        // Position along a semicircle path
        const sunX = sunProgress * 100; // 0% to 100% from left to right
        const sunY = 100 - Math.sin(sunProgress * Math.PI) * 100; // Follow a sine curve for height

        // Update sun position and visibility
        sun.style.left = `calc(${sunX}% - 100px)`;
        sun.style.top = `calc(${sunY}% - 100px)`;
        sun.style.opacity = 1;

        // Make sun larger and more yellow/orange at dawn/dusk
        if (timeDecimal < 7 || timeDecimal > 17) {
            const edgeTime = timeDecimal < 7 ? (timeDecimal - 5) / 2 : (19 - timeDecimal) / 2;
            const glowIntensity = Math.max(0.4, edgeTime);
            sun.style.transform = `scale(1.3)`;
            sun.style.boxShadow = `0 0 140px 70px rgba(255, 160, 0, ${glowIntensity})`;
        } else {
            sun.style.transform = `scale(1)`;
            sun.style.boxShadow = `0 0 100px 50px rgba(255, 255, 0, 0.4)`;
        }
    } else {
        // Hide sun at night
        sun.style.opacity = 0;
    }

    // Calculate moon position - visible from 19 to 5 (7pm to 5am)
    if (timeDecimal >= 19 || timeDecimal <= 5) {
        // Normalize time for moon position
        let moonTime = timeDecimal;
        if (moonTime < 5) {
            moonTime += 24; // Adjust for after midnight
        }

        // Calculate moon's progress (0 to 1)
        const moonProgress = (moonTime - 19) / 10;

        // Position along a semicircle path
        const moonX = moonProgress * 100; // 0% to 100% from left to right
        const moonY = 100 - Math.sin(moonProgress * Math.PI) * 100; // Follow a sine curve for height

        // Update moon position and visibility
        moon.style.left = `calc(${moonX}% - 80px)`;
        moon.style.top = `calc(${moonY}% - 80px)`;
        moon.style.opacity = 1;
    } else {
        // Hide moon during day
        moon.style.opacity = 0;
    }

    // Show stars at night, fade during dawn/dusk
    stars.forEach(star => {
        if (timeDecimal >= 19 || timeDecimal <= 5) {
            // Full night - stars visible
            star.style.opacity = 0.8 + (Math.random() * 0.2); // Slight twinkle effect
        } else if ((timeDecimal > 5 && timeDecimal < 7) || (timeDecimal > 17 && timeDecimal < 19)) {
            // Dawn or dusk - stars fading
            if (timeDecimal > 5 && timeDecimal < 7) {
                star.style.opacity = 0.8 * (1 - ((timeDecimal - 5) / 2));
            } else {
                star.style.opacity = 0.8 * ((timeDecimal - 17) / 2);
            }
        } else {
            // Day - stars hidden
            star.style.opacity = 0;
        }
    });
}

function toggleDebugMode() {
    debugMode = !debugMode;

    // Update button appearance
    const debugButton = document.getElementById('debug-button');
    if (debugMode) {
        debugButton.classList.add('active');
        // Start from current time when entering debug mode
        debugDate = new Date();
        // Change interval to update faster in debug mode
        clearInterval(clockInterval);
        clockInterval = setInterval(updateClock, 1000); // Still 1 second, but each update adds 1 hour
    } else {
        debugButton.classList.remove('active');
        // Reset to normal clock interval
        clearInterval(clockInterval);
        clockInterval = setInterval(updateClock, 1000);
        // Update immediately to show correct time
        updateClock();
    }
}

// Set up event listener for debug button
document.getElementById('debug-button').addEventListener('click', toggleDebugMode);

// Initialize clock with regular interval
clockInterval = setInterval(updateClock, 1000);
updateClock(); // Initialize clock

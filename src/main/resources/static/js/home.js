const dummyBtn = document.getElementsByClassName("dummy-btn");
const stopBtn = document.getElementsByClassName("stop-btn");
const replayBtn = document.getElementsByClassName("replay-btn");
const subject = document.getElementsByClassName("subject");
const time = document.getElementsByClassName("time");

let subjectName = subject[0].textContent;
let timeText = time[0].textContent;

dummyBtn[0].style.visibility = "hidden";
stopBtn[0].style.display = "none";

let seconds;
let timer;

function textToTime(text) {
    const [hour, minutes, seconds] = text.split(":").map(Number);
    return hour * 3600 + minutes * 60 + seconds;
}

function timeToText(time) {
    const h = Math.floor(time / 3600);
    const m = Math.floor((time % 3600) / 60);
    const s = (time % 60);

    const hour = String(h).padStart(2, "0");
    const minutes = String(m).padStart(2, "0");
    const seconds = String(s).padStart(2, "0");

    return `${hour}:${minutes}:${seconds}`;
}

function startTimer() {
    clearInterval(timer);
    seconds = textToTime(time[0].textContent);

    timer = setInterval(function() {
        seconds++;
        time[0].textContent = timeToText(seconds);
    }, 1000);
}

function stopTimer() {
    clearInterval(timer);

    fetch("/home/record", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            subject: subjectName,
            seconds: seconds
        })
    }).then(response => {
        return response.json();
    }).then(data => {
        time[0].textContent = timeToText(data.seconds);
    }).catch(error => {

    });
}

replayBtn[0].addEventListener("click", function() {
    stopBtn[0].style.display = "block";
    replayBtn[0].style.display = "none";

    startTimer();
});

stopBtn[0].addEventListener("click", function() {
    replayBtn[0].style.display = "block";
    stopBtn[0].style.display = "none";

    stopTimer();
});
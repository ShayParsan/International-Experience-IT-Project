// When the volunteer form is submitted
document.getElementById("volunteerForm").addEventListener("submit", function(event) {
    event.preventDefault();  // Prevent the form from refreshing the page

    // Get values from the form
    const volunteerName = document.getElementById("volunteerName").value;
    const volunteerEmail = document.getElementById("volunteerEmail").value;
    const volunteerEvent = document.getElementById("volunteerEvent").value;
    const volunteerMessage = document.getElementById("volunteerMessage").value;

    // Create a volunteer submission object
    const submission = {
        name: volunteerName,
        email: volunteerEmail,
        event: volunteerEvent,
        message: volunteerMessage,
        timestamp: new Date().toLocaleString() 
    };

  
    let submissions = JSON.parse(localStorage.getItem("volunteerSubmissions")) || [];


    submissions.push(submission);

    localStorage.setItem("volunteerSubmissions", JSON.stringify(submissions));

    


    document.getElementById("volunteerForm").reset();
55


    alert("Thank you for volunteering!");
});

const jobForm = document.getElementById('jobForm');
const jobList = document.getElementById('jobList');

// Base URL of your API
const BASE_URL = 'http://localhost:8080/api/jobs';

// Fetch and display all jobs
async function fetchJobs() {
    jobList.innerHTML = ''; // Clear the list
    const response = await fetch(BASE_URL);
    const jobs = await response.json();

    jobs.forEach(job => {
        const li = document.createElement('li');
        li.innerHTML = `
            <strong>${job.title}</strong> at ${job.company} (${job.location})<br>
            ${job.description}<br>
            Type: ${job.type}, Salary: $${job.salary}<br>
            <button onclick="deleteJob(${job.id})">Delete</button>
        `;
        jobList.appendChild(li);
    });
}

// Add a new job
jobForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const job = {
        title: document.getElementById('title').value,
        description: document.getElementById('description').value,
        company: document.getElementById('company').value,
        location: document.getElementById('location').value,
        type: document.getElementById('type').value,
        salary: parseFloat(document.getElementById('salary').value)
    };

    await fetch(BASE_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(job)
    });

    jobForm.reset();
    fetchJobs();
});

// Delete a job
async function deleteJob(id) {
    await fetch(`${BASE_URL}/${id}`, { method: 'DELETE' });
    fetchJobs();
}

// Initial fetch of jobs
fetchJobs();

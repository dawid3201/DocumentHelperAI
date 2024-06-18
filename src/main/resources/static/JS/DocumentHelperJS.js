function submitQuery() {
    const action = document.getElementById('action-select').value;
    const documentDetails = document.getElementById('document-details').innerText;

    fetch(`/ask`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            action: action,
            documentDetails: documentDetails
        })
    })
        .then(response => {
            if (response.status === 500) {
                // Handle 429 error
                throw new Error("429 Too many request");
            } else {
                return response.text();
            }
        })
        .then(data => {
            // Display the response in response-details element
            const responseDetails = document.getElementById('response-details');
            responseDetails.innerText = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
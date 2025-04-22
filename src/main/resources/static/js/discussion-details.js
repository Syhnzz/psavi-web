document.addEventListener("DOMContentLoaded", function () {
    const discussionId = window.location.pathname.split("/").pop();

    function loadMessages() {
        fetch(`/api/messages/discussions/${discussionId}`)
            .then(response => response.json())
            .then(messages => {
                const container = document.getElementById("message-list");
                container.innerHTML = "";

                if (!messages || messages.length === 0) {
                    container.innerHTML = "<p>Aucun message pour cette discussion.</p>";
                    return;
                }

                messages.forEach(msg => {
                    const div = document.createElement("div");
                    div.className = "card my-2";
                    div.innerHTML = `
              <div class="card-body">
                <p class="card-text">${msg.contenu}</p>
                <p class="card-text">
                  <small class="text-muted">
                    Par ${msg.auteur.username} le ${msg.dateEnvoi.replace("T", " ").substring(0, 16)}
                  </small>
                </p>
              </div>
            `;
                    container.appendChild(div);
                });
            });
    }

    loadMessages();
});
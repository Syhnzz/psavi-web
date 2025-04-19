document.addEventListener("DOMContentLoaded", function () {
    fetch("/api/discussions")
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById("discussions-list");

            if (data.length === 0) {
                container.innerHTML = "<p>Aucune discussion pour le moment.</p>";
                return;
            }

            data.forEach(discussion => {
                const card = document.createElement("div");
                card.className = "card mb-3";
                card.innerHTML = `
                    <div class="card-body">
                        <h5 class="card-title">${discussion.titre}</h5>
                        <p class="card-text">Par ${discussion.auteur.username || 'Inconnu'}</p>
                        <p class="card-text">
                            <small class="text-muted">Dernier message : ${discussion.dateDernierMessage ? discussion.dateDernierMessage.replace("T", " ").substring(0, 16) : "aucun"}</small>
                        </p>
                        <a href="/discussions/${discussion.id}" class="btn btn-outline-primary">Voir</a>
                    </div>
                `;
                container.appendChild(card);
            });
        })
        .catch(error => {
            console.error("Erreur lors du chargement des discussions :", error);
        });
});
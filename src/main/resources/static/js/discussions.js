document.addEventListener("DOMContentLoaded", function () {
    let currentPage = 0;
    const size = 5;

    function loadDiscussions(page) {
        fetch(`/api/discussions?page=${page}&size=${size}`)
            .then(response => response.json())
            .then(data => {
                const container = document.getElementById("discussions-list");
                const paginationContainer = document.getElementById("paginationContainer");

                container.innerHTML = "";
                paginationContainer.innerHTML = "";

                if (data.content.length === 0) {
                    container.innerHTML = "<p>Aucune discussion pour le moment.</p>";
                    return;
                }

                data.content.forEach(discussion => {
                    const card = document.createElement("div");
                    card.className = "card mb-3";
                    card.innerHTML = `
                        <div class="card-body">
                            <h5 class="card-title">Titre : ${discussion.titre}</h5>
                            <p class="card-text">Par ${discussion.auteur.username || 'Inconnu'}</p>
                            <p class="card-text">
                                <small class="text-muted">Dernier message : ${discussion.dateDernierMessage ? discussion.dateDernierMessage.replace("T", " ").substring(0, 16) : "aucun"}</small>
                            </p>
                            <a href="/discussion/${discussion.id}" class="btn btn-outline-primary">Voir</a>
                        </div>
                    `;
                    container.appendChild(card);
                });

                const totalPages = data.totalPages;
                const totalElements = data.totalElements;
                const currentPage = data.number;

                if (totalPages > 1) {
                    if (currentPage > 0) {
                        const prevButton = document.createElement("button");
                        prevButton.innerText = "Précédent";
                        prevButton.className = "btn btn-secondary";
                        prevButton.addEventListener("click", function () {
                            loadDiscussions(currentPage - 1);
                        });
                        paginationContainer.appendChild(prevButton);
                    }

                    for (let i = 0; i < totalPages; i++) {
                        const pageButton = document.createElement("button");
                        pageButton.innerText = i + 1;
                        pageButton.className = currentPage === i ? "btn btn-primary" : "btn btn-outline-primary";
                        pageButton.addEventListener("click", function () {
                            loadDiscussions(i);
                        });
                        paginationContainer.appendChild(pageButton);
                    }

                    if (currentPage < totalPages - 1) {
                        const nextButton = document.createElement("button");
                        nextButton.innerText = "Suivant";
                        nextButton.className = "btn btn-secondary";
                        nextButton.addEventListener("click", function () {
                            loadDiscussions(currentPage + 1);
                        });
                        paginationContainer.appendChild(nextButton);
                    }
                }
            })
            .catch(error => {
                console.error("Erreur lors du chargement des discussions :", error);
            });
    }

    loadDiscussions(currentPage);
});

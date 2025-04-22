document.addEventListener("DOMContentLoaded", () => {
    fetch('/api/user/current')
        .then(res => {
            if (!res.ok) throw new Error("Non authentifié");
            return res.json();
        })
        .then(user => {
            const container = document.getElementById("user-info");
            container.innerHTML = `
          <h5 class="mb-3">Bonjour ${user.prenom} ${user.nom} (${user.username})</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item"><strong>Email :</strong> ${user.email}</li>
            <li class="list-group-item"><strong>Adresse :</strong> ${user.adresse}, ${user.ville} (${user.region})</li>
          </ul>
        `;
        })
        .catch(err => {
            document.getElementById("user-info").innerHTML = "<p class='text-danger'>Impossible de charger les informations. Veuillez vous connecter.</p>";
        });
});
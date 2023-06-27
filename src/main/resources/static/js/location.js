const locationText = document.querySelector(".location");
const cityText = document.querySelector(".city");
const saveButton = document.querySelector(".save-button");
const locationList = document.querySelector(".location-list");

let lat, lng;
let cityName;
console.log(contextPath);
console.log("1111");

function onGeoSuccess(position) {
  lat = position.coords.latitude;
  lng = position.coords.longitude;
  locationText.innerText = `위도: ${lat}, 경도: ${lng}`;

  fetch(`${contextPath}city?lat=${lat}&lng=${lng}`)
    .then((response) => response.text())
    .then((city) => {
      console.log(city);
      cityName = city;
      cityText.innerText = city;
    });
}

function onGeoError(error) {
  console.log(error);
  locationText.innerText = "위치 정보를 가져올 수 없습니다.";
}

function onSaveButtonClick() {
  if (lat === undefined || lng === undefined || cityName === undefined) {
    alert("위치 정보를 아직 가져오지 못했습니다.");
    return;
  }

  fetch(`${contextPath}location`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      name,
      lat,
      lng,
      cityName,
    }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert("위치 정보가 저장되었습니다.");
      refreshLocationList();
    });
}

function refreshLocationList() {
  fetch(`${contextPath}location`)
    .then((response) => response.json())
    .then((locations) => {
      console.log(locations);
      locationList.innerHTML = "";

      locationList.innerHTML = `
        <tr>
          <th>이름</th>
          <th>도시</th>
          <th>위도</th>
          <th>경도</th>
          <th>저장 시간</th>
        </tr>`;
      locations.forEach((location) => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
          <td>${location.name}</td>
          <td>${location.cityName}</td>
          <td>${location.lat}</td>
          <td>${location.lng}</td>
          <td>${location.createdDate}</td>
        `;
        locationList.appendChild(tr);
      });
    });
}

navigator.geolocation.getCurrentPosition(onGeoSuccess, onGeoError);
saveButton.addEventListener("click", onSaveButtonClick);
refreshLocationList();
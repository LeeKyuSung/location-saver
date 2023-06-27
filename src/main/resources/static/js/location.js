const locationText = document.querySelector(".location");
const cityText = document.querySelector(".city");
const saveButton = document.querySelector(".save-button");

let lat, lng;
let cityName;

function onGeoSuccess(position) {
  lat = position.coords.latitude;
  lng = position.coords.longitude;
  locationText.innerText = `위도: ${lat}, 경도: ${lng}`;

  fetch(`/city?lat=${lat}&lng=${lng}`)
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

  fetch("/location", {
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
    });
}

navigator.geolocation.getCurrentPosition(onGeoSuccess, onGeoError);
saveButton.addEventListener("click", onSaveButtonClick);
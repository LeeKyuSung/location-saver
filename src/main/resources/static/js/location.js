const locationText = document.querySelector(".location");
const cityText = document.querySelector(".city");

function onGeoSuccess(position) {
    const lat = position.coords.latitude;
    const lng = position.coords.longitude;
    locationText.innerText = `위도: ${lat}, 경도: ${lng}`;

    fetch(`/city?lat=${lat}&lng=${lng}`)
        .then((response) => response.text())
        .then((city) => {
            console.log(city);
            cityText.innerText = city;
        });
}

function onGeoError(error) {
    console.log(error);
    locationText.innerText = "위치 정보를 가져올 수 없습니다.";
}

navigator.geolocation.getCurrentPosition(onGeoSuccess, onGeoError);
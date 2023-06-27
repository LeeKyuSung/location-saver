const locationText = document.querySelector(".location");

function onGeoSuccess(position) {
    const lat = position.coords.latitude;
    const lng = position.coords.longitude;
    locationText.innerText = `위도: ${lat}, 경도: ${lng}`;
}

function onGeoError(error) {
    console.log(error);
    locationText.innerText = "위치 정보를 가져올 수 없습니다.";
}

navigator.geolocation.getCurrentPosition(onGeoSuccess, onGeoError);
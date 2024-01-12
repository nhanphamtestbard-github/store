class App {
	static DOMAIN_SERVER = "http://localhost:9000";
	static PROVINCE_URL = "https://vapi.vnappmob.com/api/province/";

	static getCurrentDate() {
		let today = new Date();
		let date = today.getDate() + '/' + (today.getMonth() + 1) + '/' + today.getFullYear();
		return date;
	}

	static showCurrentDate(tagId) {
		console.log(tagId);
		$(tagId).text(this.getCurrentDate());

	}

	static getNewClock(tagId) {

		let clock = new Date();
		let hour = clock.getHours();
		let minutes = clock.getMinutes();
		let seconds = clock.getSeconds();

		let printClock = hour + " : " + minutes + " : " + seconds;

		$(tagId).text(printClock);
	}
}
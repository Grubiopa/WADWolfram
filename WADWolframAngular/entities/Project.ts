export class Project{
	private id:number;
	private title:string;
	private shortDescription:string;
	private description:string;
	private totalBudget:number;
	private parcialBudget:number;
	private restBudget:number;
	private time:number;
	private opened:boolean;
	private releaseDate:Date;
	private startYear:number;
	private image:string;
	private donations:Array<Donation>;
	constructor(title:string, shortDescription:string, description:string, totalBudget:number, parcialBudget:number,
			time:number, opened:boolean, releaseDate:Date, startYear:number, image:string) {
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.totalBudget = totalBudget;
		this.parcialBudget = parcialBudget;
		this.restBudget = totalBudget - parcialBudget;
		this.time = time;
		this.opened = opened;
		this.releaseDate = releaseDate;
		this.startYear = startYear;
		this.image = image;
		this.donations = new Array();
	}

	getId() {
		return this.id;
	}

	setId(id:number) {
		this.id = id;
	}

	getImage() {
		return this.image;
	}

	setImage(image:string) {
		this.image = image;
	}

	getTitle() {
		return this.title;
	}

	setTitle(title:string) {
		this.title = title;
	}

	getShortDescription() {
		return this.shortDescription;
	}

	setShortDescription(shortDescription:string) {
		this.shortDescription = shortDescription;
	}

	getDescription() {
		return this.description;
	}

	setDescription(description:string) {
		this.description = description;
	}

	getTotalBudget() {
		return this.totalBudget;
	}

	setRestBudget(restBudget:number) {
		this.restBudget = restBudget;
	}

	setTotalBudget(totalBudget:number) {
		this.totalBudget = totalBudget;
		this.setRestBudget(this.totalBudget - this.parcialBudget);
	}

	getParcialBudget() {
		return this.parcialBudget;
	}

	setParcialBudget(parcialBudget:number) {
		this.parcialBudget = parcialBudget;
	}

	getRestBudget() {
		return this.restBudget;
	}

	getTime() {
		return this.time;
	}

	setTime(time:number) {
		this.time = time;
	}

	getOpened() {
		return this.opened;
	}

	setOpened(opened:boolean) {
		this.opened = opened;
	}

	getReleaseDate() {
		return this.releaseDate;
	}

	setReleaseDate(releaseDate:Date) {
		this.releaseDate = releaseDate;
	}

	getStartYear() {
		return this.startYear;
	}

	setStartYear(startYear:number) {
		this.startYear = startYear;
	}

	getDonations() {
		return this.donations;
	}

	setDonations(donations:Array<Donation>) {
		this.donations = donations;
	}

	addDonation(d:Donation) {
		this.donations.push(d);
		this.setParcialBudget(this.parcialBudget + d.getMoney());
	}

	calculateProgressPercentage() {
		return (this.parcialBudget * 100 / this.totalBudget);
	}
}

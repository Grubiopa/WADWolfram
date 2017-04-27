export interface Project{
	id:number;
	title:string;
	shortDescription:string;
	description:string;
	totalBudget:number;
	parcialBudget:number;
	restBudget:number;
	time:number;
	opened:boolean;
	releaseDate:Date;
	startYear:number;
	image:string;
}

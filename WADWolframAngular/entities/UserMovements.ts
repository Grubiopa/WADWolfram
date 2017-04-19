export class UserMovements{
    private projectTitle:string;
	private money:number;
    private date:Date;

    constructor(title:string,money:number,date:Date){
        this.projectTitle=title;
        this.money=money;
        this.date=date;
    }

    getProjectTitle(){
        return this.projectTitle;
    }
    getMoney(){
        return this.money;
    }
    getDate(){
        return this.date;
    }
}
export class New {
    private id:number;
    private title:string;
    private body:string;
    private category:string;
    private number_comments:number;
    private date:Date;
   
    constructor(title:string, body:string, category:string, date:Date) {
        this.title = title;
        this.body = body;
        this.category = category;
        this.date = date;
        this.number_comments = 0;
    }

    getId() {
        return this.id;
    }

    getTitle() {
        return this.title;
    }

    getBody() {
        return this.body;
    }

    getCategory() {
        return this.category;
    }

    getDate() {
        return this.date;
    }

    getNumberComments() {
        return this.number_comments;
    }

    setTitle(title:string) {
        this.title = title;
    }

    setBody(body:string){
        this.body=body;
    }

    setCategory(category:string) {
        this.category = category;
    }

   setNumberComments(number_comments:number) {
        this.number_comments = number_comments;
    }

    setDate(date:Date) {
        this.date = date;
    }

    setId(id:number) {
        this.id = id;
    }
}
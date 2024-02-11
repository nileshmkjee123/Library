class HistoryModel{
    id: number;
    userEmail: string;
    checkoutDate: string;
    returnedDate: string;
    title: string;
    author: string;
    description: string;
    img: string;
    constructor(id: number,
        userEmail: string,
        checkoutDate: string,
        returnedDate: string,
        title: string,
        author: string,
        description: string,
        img: string){
            this.id=id;
        this.userEmail=userEmail;
        this.author=author;
        this.returnedDate=returnedDate;
        this.checkoutDate=checkoutDate;
        this.title=title;
        this.img=img;
        this.description=description;
    }
}

export default HistoryModel;
const commentContents=document.getElementById("commentContents")
const commentButton =document.getElementById("commentButton")
const commentClose =document.getElementById("commentClose")
const commentList =document.getElementById("commentList")


getList(1);

function getList(page){
    fetch("commentList?p_code="+commentButton.getAttribute("data-id")+"&page="+page,{
        method:"GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}
commentList.addEventListener("click",(e)=>{
    e.preventDefault(); 
   if(e.target.classList.contains("pn")){
   let p = e.target.getAttribute("data-page-num")
    getList(p);
   } 
})


commentList.addEventListener("click",(e)=>{
    if(e.target.classList.contains("del")){
       let id= e.target.getAttribute("data-comment-del");
       fetch("commentDelete",{
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"comments_num="+id
       })
       .then(r=>r.text())
       .then(r=>{
        r=r.trim();
        if(r>0){
            alert('성공')
            getList(1)
        }
    })
    }

})
  
                                                  
                               
    commentButton.addEventListener("click", ()=>{
    commentClose.click();
    let contents =commentContents.value;
       fetch("commentAdd",{
        method:"POST" ,
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"comments_Content="+contents+"&p_code="+commentButton.getAttribute("data-id")
       })
.then(r=>r.text())
.then(r=>{
    r=r.trim();
    if(r>0){
        
        getList(1);
    }
})

    commentContents.value="";

})

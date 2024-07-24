const wishDelete = document.getElementsByClassName("wishDelete");
const all = document.getElementById("all");
const ch = document.getElementsByClassName("ch");
const delAll =document.getElementById("delAll");


delAll.addEventListener("click",()=>{
const e=[];
    let url="deleteWishList?"
    for(let c of ch){
        if(c.checked){
            let id= c.getAttribute("data-wish-id");
            url=url+"p_code="+id+"&";
            e.push(c.getAttribute("data-del-id"));
        }
    }
    url=url.substring(0,url.length-1);
    fetch(url,{
        method:"GET"
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            for(let ele of e){
                document.getElementById(ele).remove();
            }
        }else{
            alert("실패 하였습니다.");
        }
    }).catch(()=>{alert("삭제 실패")});


});


       






for(let w of wishDelete){
    w.addEventListener("click",()=>{
        let id =w.getAttribute("data-wish-id");
        //Server 삭제 요청 코드
        //option= js의 객체 형식으로 보낸다
    
        fetch("./deleteWishList?p_code="+id,{
            method:"GET"
        }) .then((r)=>{return r.text()})
        .then((r)=>{
            r=r.trim();
            if(r>0){
                //  w.parentNode.parentNode.remove();
                let del = w.getAttribute("data-del-id")
                document.getElementById(del).remove();

            }else{
                alert("실패 하였습니다.");
            }
        }).catch(()=>{alert("삭제 실패")});


    });

}
all.addEventListener("click", ()=>{
    for(let c of ch){
        c.checked=all.checked;
    } 
    
})

for(let c of ch){
    c.addEventListener("click", ()=>{

        let flag=true;
        for(let check of ch){
            if(!check.checked){
                flag =false;
                break;
            }
        }
        all.checked=flag;
    })
}


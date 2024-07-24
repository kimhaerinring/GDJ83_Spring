const wishDelete =document.getElementsByClassName("wishDelete");
const checkall = document.getElementById("checkall")
const ch = document.getElementsByClassName("ch");
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

// checkall.addEventListener("click",()=>{
//     for(let c of ch){
//         c.checked=all.checked;
//     }
// })
// for(let c of ch){
//     c.addEventListener("click",()=>{
//         let flag = true;
//         for(let check of ch){
//             if(! check.checked){
//                 flag=false;
//                 break;
//             }
//         }
//         all.checked=flag;
//     })

// }





function checkSelectAll(checkbox)  {
  const selectall 
    = document.querySelector('input[name="selectall"]');
  
  if(checkbox.checked === false)  {
    selectall.checked = false;
  }
}

function selectAll(selectAll)  {
  const checkboxes 
     = document.getElementsByName('product');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked
  })
}
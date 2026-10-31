document.getElementById("loginForm").addEventListener("submit",e=>{
 e.preventDefault();
 localStorage.setItem("erpUser",JSON.stringify({username:document.getElementById("username").value,role:document.getElementById("role").value}));
 location.href="dashboard.html";
});

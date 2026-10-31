const API_BASE="http://localhost:8080/api";
async function apiRequest(endpoint,options={}){
 const response=await fetch(API_BASE+endpoint,{headers:{"Content-Type":"application/json"},...options});
 if(!response.ok) throw new Error(await response.text()||"Request failed");
 return response.status===204?null:response.json();
}

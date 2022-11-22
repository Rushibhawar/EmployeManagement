
/*Search function */
 function searchFunction(){
	let searchInput, searchInputFilter, empDetails, divTag, div, divText,i ,j;
	
	/*get search input value*/
	searchInput = document.getElementById("search-box").value;
	
	/*change input value to lowercase */
	searchInputFilter = searchInput.toLowerCase();
	
	/*get every div element inside emp-grid-container class */
	empDetails = document.getElementsByClassName('emp-grid-container');
	let x = empDetails[0].getElementsByTagName("div");
	
	/*set i = 6 and increment by 5 to search using employee name */
	i = 6 ;
	while(i < x.length) {
		
		/*if the Ename and search input matches diplay it else display none */
		if(x[i].innerHTML.toLowerCase().includes(searchInputFilter)) {
			for(j = i-1; j <= i+3; j++) {
				//console.log(j);
				x[j].style.display = "list-item";
			}
			
		}
		else {
			for(j = i-1; j <= i+3; j++) {
				console.log(j);
				x[j].style.display = "none";
			}
		}
		i = i+5;
	}		
}

/*add button javascript */
function displayPopup(){
	let modal = document.getElementsByClassName("modal");
	//console.log(modal);
	modal[0].style.display = "block"; 
}

/*close the add popup */
function closeModal(){
	let modal = document.getElementsByClassName("modal");
	modal[0].style.display = "none";
}

/*function to send eid to Loadename servlet */
function  getSelectedeid(id) {
	var selectedText = id.options[id.selectedIndex].innerHTML;
	var selectedValue = id.value;
	location.href = "Loadename?emp_id="+selectedText;
}							
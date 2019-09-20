/**
 * 
 */
function getOriginalLink(data) {
	if(checkImageType(data)){
		return data.substring(0, 12) + data.substring(14);
	}else{
		return data;
	}
}

function getOriginalName(filename) {
	return filename.substring(filename.lastIndexOf("_")+1);
}

function checkImageType(data) {
	var pattern = /jpg|png|jpeg|gif/i;
	return data.match(pattern);
}
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {

// Initialize an empty array to hold the chunked subarrays
    var result = [];

// Loop through the input array 'arr' with a step of 'size'
    for (var i = 0; i < arr.length; i += size) {

        result.push(arr.slice(i, i + size));
    }

// Return the array containing all the chunked subarrays
    return result;
};


console.log(chunk([1, 2, 3, 4, 5], 1)); 
console.log(chunk([1, 9, 6, 3, 2], 3)); 
console.log(chunk([8, 5, 3, 2, 6], 6)); 
console.log(chunk([], 1)); 
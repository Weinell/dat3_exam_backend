My Maven verify does not work!
	* Did you open Docker? (your local database)
		* Is your image running on Docker?
	* Are you using the correct version of JDK? E.g. Amazon Coretta 11
	* Did you check your persistence.xml matches the docker image? (startcode and startcode_test)
	* Did you check whether you created a database with the name specified in the POM on your droplet? (<db.name>)

My Verify works, but my actions does not!
	* Is your github project's head branch main or master?	
	* Is your maven workflow (yaml) set to push on main or master?
	* Did you remember to add secrets? (same secrets as on your droplet)

My droplet is slooooow
	* Restart your server on digital ocean
	* Add swap space - takes 5 mins (https://www.digitalocean.com/community/tutorials/how-to-add-swap-space-on-ubuntu-20-04)

I made an endpoint, but it doesn't work...
	* Did you add the resource to ApplicationConfig?
	* Is the Jersey Bundle dependency in your POM? (Eclipse Jax-RS)

	


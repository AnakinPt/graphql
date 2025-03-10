# Demo for Graphql

./gradlew bootRun

## Some test data

```graphql
query FetchAuthors($authorName:String) {
  authorsList(name:$authorName) {
    id
    name
  }
}

query RecentPosts {
  recentPosts(count:10, offset:0)
  {
    id
    title
		author {
      id
      name
    }
  }
}

mutation CreateAuthor($authorName: String!) {
     createAuthor(name: $authorName) {
    id
  }
}

mutation CreatePost($newPost: NewPost!){
  	createPost(post:$newPost) 
  	{ 
    	id
      title
      author {
        id
      }
  	}
}
```

And as variables:
```json
{ 
  "newPost": {
    "title":"Song of Ice and Fire", 
    "text": "History of Westeros and Winterfell", 
    "category":"Books", 
    "author": "14c701df-cdab-42b6-b121-462aa47d6b5e"
  },
  "authorName": "George Martin"
}
```
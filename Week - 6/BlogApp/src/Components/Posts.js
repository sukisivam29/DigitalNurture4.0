import React from 'react';

class Posts extends React.Component {
    constructor(props){
        super(props);
        this.state={
            posts :[],
            hasError: false,
            error: null
        };
    }
    loadPosts = () => {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => this.setState({ posts: data }))
            .catch(error => {
                this.setState({ hasError: true, error });
            });
    };

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert('An error occurred: ' + error);
        this.setState({ hasError: true, error });
    }

    render() {
        if (this.state.hasError) {
            return <div>Error loading posts.</div>;
        }
        return (
            <div>
                <h2>Posts</h2>
                {this.state.posts.map(post => (
                    <div key={post.id}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}
export default Posts;
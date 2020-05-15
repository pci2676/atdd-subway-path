const METHOD = {
  PUT() {
    return {
      method: 'PUT'
    }
  },
  DELETE() {
    return {
      method: 'DELETE'
    }
  },
  POST(data) {
    return {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        ...data
      })
    }
  }
}

const api = (() => {
  const request = (uri, config) => fetch(uri, config).then(data => data.json())

  const line = {
      getAll() {
          return request(`/lines/map`)
      },
  }

  const path = {
    find(params) {
        return request(`/paths?source=${params.source}&target=${params.target}&key=${params.type}`)
    }
  }

  return {
    line,
    path
  }
})()

export default api
